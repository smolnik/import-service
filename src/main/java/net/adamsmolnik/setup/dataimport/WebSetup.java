package net.adamsmolnik.setup.dataimport;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import net.adamsmolnik.boundary.dataimport.ImportActivityImpl;
import net.adamsmolnik.control.dataimport.Importer;
import net.adamsmolnik.setup.ActivityLauncher;

/**
 * @author ASmolnik
 *
 */
@WebListener("importActivitySetup")
public class WebSetup implements ServletContextListener {

    @Inject
    private Importer importer;

    @Inject
    private ActivityLauncher al;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        al.register(new ImportActivityImpl(importer));
        al.launch();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        al.shutdown();
    }

}
