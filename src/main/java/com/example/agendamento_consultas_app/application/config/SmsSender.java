package com.example.agendamento_consultas_app.application.config;

import org.springframework.stereotype.Component;

@Component
public class SmsSender {

    private final String accountSid;
    private final String authToken;
    private final String fromNumber;


    public SmsSender() {
        this.accountSid = "your_account_sid";
        this.authToken = "your_auth_token";
        this.fromNumber = "your_twilio_number";
    }


    public void sendSms(Long toNumber, String messageBody) {

        try {
            com.twilio.Twilio.init(accountSid, authToken);


            com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message
                    .creator(
                            new com.twilio.type.PhoneNumber("+55" + toNumber),  // Número do destinatário
                            new com.twilio.type.PhoneNumber(fromNumber),       // Número do remetente (Twilio)
                            messageBody                                       // Corpo da mensagem
                    )
                    .create();

            // Exibir ID da mensagem (opcional)
            System.out.println("Mensagem enviada com sucesso. SID: " + message.getSid());
        } catch (Exception e) {
            // Tratar exceções caso o envio falhe
            System.err.println("Erro ao enviar SMS: " + e.getMessage());
        }
    }
}
