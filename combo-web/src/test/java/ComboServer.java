import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by YangFalcom on 16/6/7.
 */
public class ComboServer {

    public static void main(String[] args) {
        Server server = new Server(8060);

        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setDescriptor("./combo-web/src/main/webapp/WEB-INF/web.xml");
        context.setResourceBase("./combo-web/src/main/webapp");
        //解决静态资源缓存后再ide里面不能修改问题
        context.setDefaultsDescriptor("./combo-web/src/test/resources/webdefault.xml");
        context.setParentLoaderPriority(true);
        server.setHandler(context);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
