@Configuration
public class ThymeleafConfiguration {

    private final Logger log = LoggerFactory.getLogger(ThymeleafConfiguration.class);

    @Autowired
    private Environment env;

    @Bean
    public TemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCharacterEncoding(CharEncoding.UTF_8);
        if (env.acceptsProfiles(Constants.SPRING_PROFILE_DEVELOPMENT)) {
            resolver.setCacheable(false); // default is true (for prod)
        } else {
            log.info("Cache des templates Thymeleaf activé");
        }
        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        engine.addDialect(new ConditionalCommentsDialect());
        engine.addDialect(new LayoutDialect());
        if (env.acceptsProfiles(Constants.SPRING_PROFILE_PRODUCTION)) {
            log.info("Cache manager activé");
            engine.setCacheManager(thymeleafCacheManager());
        }
        return engine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding(CharEncoding.UTF_8);
        return resolver;
    }

    @Bean
    public StandardCacheManager thymeleafCacheManager() {
        StandardCacheManager cacheManager = new StandardCacheManager();
        cacheManager.setTemplateCacheMaxSize(500);
        cacheManager.setFragmentCacheMaxSize(1000);
        return cacheManager;
    }

}