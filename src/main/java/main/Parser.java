package main;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import computer.Operand;

public class Parser {

    private LinkedList<Operand> stack = new LinkedList<>();
    private Map<String, OperatorClassRecord> operators = new HashMap<String, OperatorClassRecord>();

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
            final int parameterCount = constructor.getParameterCount();
            if ((parameterCount < 1) || (parameterCount > 2)) {
                throw new IllegalArgumentException("class " + clazz.getName() + " is not a proper operator class (it constructor should have 1 or 2 parameters)");
            }
            final OperatorClassRecord classRecord = new OperatorClassRecord(parameterCount,
                                                                            (final Operand[] o) -> { try {
                                                                                return (parameterCount == 1) ? (Operand)constructor.newInstance(o[0])
                                                                                                             : (Operand)constructor.newInstance(o[0], o[1]);
                                                                            } catch (final InstantiationException |
                                                                                           IllegalAccessException |
                                                                                           IllegalArgumentException |
                                                                                           InvocationTargetException e) {
                                                                                throw new IllegalArgumentException("class " + clazz.getName() + " is not a proper operator class", e);
                                                                            }});
            this.operators.put(syntax, classRecord);
        } catch (final SecurityException | IllegalArgumentException e) {
            throw new IllegalArgumentException("class " + clazz.getName() + " is not a proper operator class", e);
        }
    }

    public Operand parse(final List<String> program) {

        int lineNumber = 0;
        for (final String programLine: program) {
            lineNumber++;
            if (operators.containsKey(programLine)) {
                final OperatorClassRecord classRecord = operators.get(programLine);
                final Operand[] o = new Operand[classRecord.getParameterCount()];
                for (int i = 0; i < classRecord.getParameterCount(); i++) {
                    final int paramNumber = classRecord.getParameterCount() - i;
                    if (stack.isEmpty()) {
                        System.err.println("stack is empty when trying to get parameter number " + (i + 1) + " of operator \"" + programLine + "\" (line number " + lineNumber + ")");
                        System.exit(1);
                    }
                    o[paramNumber - 1] = this.stack.pop();
                }
                stack.push(classRecord.getConstructor().apply(o));
            } else {
                final double value = Double.parseDouble(programLine);
                stack.push(new computer.Number(value, programLine));
            }
        }
        if (stack.isEmpty()) {
            System.err.println("stack is empty when trying to get final result (line number " + lineNumber + ")");
            System.exit(1);
        }
        return stack.pop();
    }

    public class OperatorClassRecord {
        private int parameterCount;
        private Function<Operand[], Operand> constructor;
        public OperatorClassRecord(final int parameterCount,
                                   final Function<Operand[], Operand> constructor) {
            this.parameterCount = parameterCount;
            this.constructor = constructor;
        }
        public int getParameterCount() {
            return parameterCount;
        }
        public Function<Operand[], Operand> getConstructor() {
            return constructor;
        }
    }
}
