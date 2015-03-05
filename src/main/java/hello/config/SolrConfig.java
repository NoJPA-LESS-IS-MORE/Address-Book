package hello.config;

import dk.lessismore.nojpa.reflection.db.model.ModelObjectInterface;
import dk.lessismore.nojpa.reflection.db.model.ModelObjectSearchService;
import dk.lessismore.nojpa.reflection.db.model.SolrService;
import dk.lessismore.nojpa.reflection.db.model.SolrServiceImpl;
import hello.model.Address;
import hello.model.Person;
import hello.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created with IntelliJ IDEA.
 * User: niakoi
 * Date: 4/24/14
 * Time: 3:06 PM
 */
@PropertySource("classpath:NoJpa.properties")
@Configuration
public class SolrConfig {

    @Bean
    public SolrService userSolrService(@Value("${userSolr.coreName}") String coreName,
                                       @Value("${createDatabase}") boolean cleanOnStartup) {
        return getSolrService(User.class, coreName, cleanOnStartup);
    }


    @Bean
    public SolrService addressSolrService(@Value("${addressSolr.coreName}") String coreName,
                                       @Value("${createDatabase}") boolean cleanOnStartup) {
        return getSolrService(Address.class, coreName, cleanOnStartup);
    }

    @Bean
    public SolrService personSolrService(@Value("${personSolr.coreName}") String coreName,
                                       @Value("${createDatabase}") boolean cleanOnStartup) {
        return getSolrService(Person.class, coreName, cleanOnStartup);
    }


    private SolrService getSolrService(Class<? extends ModelObjectInterface> clazz, String coreName, boolean cleanOnStartup) {
        SolrServiceImpl solrService = new SolrServiceImpl();
        solrService.setCoreName(coreName);
        solrService.setCleanOnStartup(cleanOnStartup);
        ModelObjectSearchService.addSolrServer(clazz, solrService.getServer());
        return solrService;

    }
}
