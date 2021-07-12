package main;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import computer.IncrementStack;
import computer.Operand;
import computer.VarOperator;

public class Parser {

    private final LinkedList<Operand> stack = new LinkedList<>();
    private final IncrementStack incrementStack = new IncrementStack();
    private final Map<String, OperatorClassRecord> operators = new HashMap<String, OperatorClassRecord>();

    public Parser() {
    }

    public void addOperatorClass(final Class<?> clazz) {

        try {
            final String className = clazz.getSimpleName();
            if (!className.endsWith("Operator")) {
                throw new IllegalArgumentException("class " + clazz.getName() + " does not end with \"Operator\"");
            }
            final String syntax = className.substring(0, className.length() - 8).toLowerCase();
            final Constructor<?>[] constructors = clazz.getConstructors();
            if (constructors.length != 1) {
                throw new IllegalArgumentException("class " + clazz.getName() + " is not a proper operator class (it should have one and only one constructor)");
            }
            final Constructor<?> constructor = constructors[0];
            final Class<?>[] parameterTypes = constructor.getParameterTypes();
            final int parameterCount = parameterTypes.length;
            if (parameterCount == 0) {
                throw new IllegalArgumentException("class " + clazz.getName() + " is not a proper operator class (its constructor has no parameter)");
            }
            final boolean lastParameterIsIncrementStack = parameterTypes[parameterCount - 1].equals(IncrementStack.class);
            for (int i = 0 ; i < parameterCount ; i++) {
                if (!parameterTypes[i].equals(Operand.class) && ((i != parameterCount - 1) || !lastParameterIsIncrementStack)) {
                    throw new IllegalArgumentException("class " + clazz.getName() + " is not a proper operator class (its constructor should have Operand parameter, except for the last that can be IncrementStack)");
                }
            }
            final OperatorClassRecord classRecord = new OperatorClassRecord(parameterCount - (lastParameterIsIncrementStack ? 1 : 0),
                                                                            buildConstructorCall(constructor, parameterCount, lastParameterIsIncrementStack));
            this.operators.put(syntax, classRecord);
        } catch (final SecurityException | IllegalArgumentException e) {
            throw new IllegalArgumentException("class " + clazz.getName() + " is not a proper operator class", e);
        }
    }

    private BiFunction<Operand[], IncrementStack, Operand> buildConstructorCall(final Constructor<?> constructor,
                                                                                final int parameterCount,
                                                                                final boolean lastParameterIsIncrementStack) {
        // kludge to fix the impedance mismatch between using arrays and multiple parameters...
        if (lastParameterIsIncrementStack) {
            switch (parameterCount) {
            case 1: return (final Operand[] o, final IncrementStack s) -> {
                try {
                    return (Operand)constructor.newInstance(s);
                } catch (final InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    throw new IllegalArgumentException("class " + constructor.getDeclaringClass().getName() + " is not a proper operator class", e);
                }};
            case 2: return (final Operand[] o, final IncrementStack s) -> {
                try {
                    return (Operand)constructor.newInstance(o[0], s);
                } catch (final InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    throw new IllegalArgumentException("class " + constructor.getDeclaringClass().getName() + " is not a proper operator class", e);
                }};
            case 3: return (final Operand[] o, final IncrementStack s) -> {
                try {
                    return (Operand)constructor.newInstance(o[0], o[1], s);
                } catch (final InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    throw new IllegalArgumentException("class " + constructor.getDeclaringClass().getName() + " is not a proper operator class", e);
                }};
            case 4: return (final Operand[] o, final IncrementStack s) -> {
                try {
                    return (Operand)constructor.newInstance(o[0], o[1], o[2], s);
                } catch (final InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    throw new IllegalArgumentException("class " + constructor.getDeclaringClass().getName() + " is not a proper operator class", e);
                }};
            default:
                throw new IllegalArgumentException("class " + constructor.getDeclaringClass().getName() + " is not a proper operator class (its contructor has too many parameters");
            }
        }else {
            switch (parameterCount) {
            case 1: return (final Operand[] o, final IncrementStack s) -> {
                try {
                    return (Operand)constructor.newInstance(o[0]);
                } catch (final InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    throw new IllegalArgumentException("class " + constructor.getDeclaringClass().getName() + " is not a proper operator class", e);
                }};
            case 2: return (final Operand[] o, final IncrementStack s) -> {
                try {
                    return (Operand)constructor.newInstance(o[0], o[1]);
                } catch (final InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    throw new IllegalArgumentException("class " + constructor.getDeclaringClass().getName() + " is not a proper operator class", e);
                }};
            case 3: return (final Operand[] o, final IncrementStack s) -> {
                try {
                    return (Operand)constructor.newInstance(o[0], o[1], o[2]);
                } catch (final InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    throw new IllegalArgumentException("class " + constructor.getDeclaringClass().getName() + " is not a proper operator class", e);
                }};
            case 4: return (final Operand[] o, final IncrementStack s) -> {
                try {
                    return (Operand)constructor.newInstance(o[0], o[1], o[2], o[4]);
                } catch (final InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    throw new IllegalArgumentException("class " + constructor.getDeclaringClass().getName() + " is not a proper operator class", e);
                }};
            default:
                throw new IllegalArgumentException("class " + constructor.getDeclaringClass().getName() + " is not a proper operator class (its contructor has too many parameters");
            }
        }
    }

    public Operand parse(final List<String> expression) {

        int lineNumber = 0;
        for (final String line: expression) {
            lineNumber++;
            if (operators.containsKey(line)) {
                final OperatorClassRecord classRecord = operators.get(line);
                final Operand[] o = new Operand[classRecord.getOperandCount()];
                for (int i = 0; i < classRecord.getOperandCount(); i++) {
                    final int paramNumber = classRecord.getOperandCount() - i;
                    if (stack.isEmpty()) {
                        System.err.println("stack is empty when trying to get parameter number " + (i + 1) + " of operator \"" + line + "\" (line number " + lineNumber + ")");
                        System.exit(1);
                    }
                    o[paramNumber - 1] = this.stack.pop();
                }
                stack.push(classRecord.getConstructor().apply(o, incrementStack));
            } else if (line.startsWith("var ")) {
                final int varNumber = Integer.parseInt(line.substring(4));
                stack.push(new VarOperator(varNumber, incrementStack));
            } else {
                final double value = Double.parseDouble(line);
                stack.push(new computer.Number(value, line));
            }
        }
        if (stack.isEmpty()) {
            System.err.println("stack is empty when trying to get final result (line number " + lineNumber + ")");
            System.exit(1);
        }
        return stack.pop();
    }

    public class OperatorClassRecord {
        private final int operandCount;
        private final BiFunction<Operand[], IncrementStack, Operand> constructor;
        public OperatorClassRecord(final int operandCount,
                                   final BiFunction<Operand[], IncrementStack, Operand> constructor) {
            this.operandCount = operandCount;
            this.constructor = constructor;
        }
        public int getOperandCount() {
            return operandCount;
        }
        public BiFunction<Operand[], IncrementStack, Operand> getConstructor() {
            return constructor;
        }
    }
}
