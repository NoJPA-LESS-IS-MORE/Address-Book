package hello.config;

import dk.lessismore.nojpa.reflection.db.model.ModelObjectInterface;
import dk.lessismore.nojpa.reflection.db.model.ModelObjectSearchService;
import dk.lessismore.nojpa.reflection.db.model.SolrService;
import dk.lessismore.nojpa.reflection.db.model.SolrServiceImpl;
import hello.model.Address;
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
@PropertySource("classpath:SolrConfig.properties")
@Configuration
public class SolrConfig {

    @Bean
    public SolrService addressSolrService(@Value("${coreName}") String coreName,
                                          @Value("${cleanOnStartup}") boolean cleanOnStartup) {
        return getSolrService(Address.class, coreName, cleanOnStartup);
    }
//    @Bean
//    public SolrService personrSolrService(@Value("${coreName}") String coreName,
//                                       @Value("${cleanOnStartup}") boolean cleanOnStartup) {
//        return getSolrService(Person.class, coreName, cleanOnStartup);
//    }

    private SolrService getSolrService(Class<? extends ModelObjectInterface> clazz, String coreName, boolean cleanOnStartup) {
        SolrServiceImpl solrService = new SolrServiceImpl();
        solrService.setCoreName(coreName);
        solrService.setCleanOnStartup(cleanOnStartup);
        ModelObjectSearchService.addSolrServer(clazz, solrService.getServer());
        return solrService;
    }
}
