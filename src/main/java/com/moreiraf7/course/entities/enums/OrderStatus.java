package com.moreiraf7.course.entities.enums;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVEREED(4),
    CANCELED(5);

    //CODIGO PARA O TIPO ENUMERADO
    private int code;

    // COONSTRUCTOR
    private OrderStatus(int code) {
        this.code = code;
    }

    //METODO PARA ACESSAR O CODIGO
    public int getCode() {
        return code;
    }


    // METODO PARA CONVERTER UM VALOR NUMERICO PARA O TIPO ENUMERADO
    public static OrderStatus valueOf(int code) {
        /* será passado o código e o metodo retorna o status do pedido CORRESPONDENTE ao código */
        for(OrderStatus value : OrderStatus.values()) {
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalide Order Status code"); // Exceção caso código( int code) seja inválido
    }
}
