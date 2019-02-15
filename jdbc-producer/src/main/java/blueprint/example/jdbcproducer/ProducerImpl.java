package blueprint.example.jdbcproducer;

import blueprint.example.producer.api.Producer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.springframework.stereotype.Component;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class ProducerImpl implements Producer {

    private static final Log log = LogFactoryUtil.getLog(ProducerImpl.class);

    @Override
    public String produceString() {

        Thread thread = Thread.currentThread();

        ClassLoader origLoader = thread.getContextClassLoader();

        thread.setContextClassLoader(PortalClassLoaderUtil.getClassLoader());

        String s = null;

        try {

            InitialContext ctx = new InitialContext();
            DataSource datasource = (DataSource)
                    ctx.lookup("java:jboss/datasources/LiferayDS");

            Connection connection = datasource.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM ibox_staff");
            ResultSet rs = statement.getResultSet();
            if (rs.next())
                s = rs.getString(1);

            connection.close();
        } catch (NamingException ne) {

            log.error(ne);

        } catch (SQLException sqle) {

            log.error(sqle);

        } finally {
            thread.setContextClassLoader(origLoader);
        }

        return s;

    }

}
