public enum OperatorType {
    ADD ('+'),
    SUBTRACTION ('-'),
    MULTIPLY ('*'),
    DIVIDE ('/');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static OperatorType fromSymbol(char symbol){
        for(OperatorType op : values()){
            if(op.getSymbol() == symbol){
                return op;
            }
        }
        return null;
    }
}

