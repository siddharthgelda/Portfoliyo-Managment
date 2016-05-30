

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.manager.PorfoliyoManagerImpl;
import com.manager.PortfoliyoManager;
import com.model.Portfoliyo;


@ComponentScan("com")
@SpringBootApplication
public class Application {
	
	@Autowired PortfoliyoManager man;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
