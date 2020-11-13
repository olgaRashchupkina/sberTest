import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

//@Path("/sender")
@ApplicationScoped
//@Stateless
public class Producer {
    //получаем ресурсы сервера для отправки сообщений
    @Resource(name="jms/sberTestTool")
    private ConnectionFactory connectionFactory;

    @Resource(name="jms/SberTestTopic")
    private Destination destination;

    public String getEnterString() {
        return "enterString";
    }

//    @Inject
//    @JMSConnectionFactory(
//            "jms/sberTestTool") private JMSContext context;
//    Producer(){
//        this.context = connectionFactory.createContext();
//    }

    public void sendMessage(String enterString) {
//        String enterString = "dsf";
//        ConnectionFactory connectionFactoryTest = new ConnectionFactory("jms/sberTestTool");
        try (JMSContext context = connectionFactory.createContext()){
            context.createProducer().send(destination, enterString);
        } catch (JMSRuntimeException ex) {
            System.err.println("Sending message error");
            ex.printStackTrace();
        }
    }

//    @GET
    public void sendMessage() {
        String enterString = "ddsfsg";
        try {
            //создаем подключение
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            //добавим в JMS сообщение собственное свойство в поле сообщения со свойствами
            message.setStringProperty("clientType", "web clien");
            //добавляем payload в сообщение
            message.setText(enterString);
            //отправляем сообщение
            producer.send(message);
            System.out.println("message sent");
            //закрываем соединения
            session.close();
            connection.close();

        } catch (JMSException ex) {
            System.err.println("Sending message error");
            ex.printStackTrace();
        }
    }
}
