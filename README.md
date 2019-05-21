# Dictionary
Dictionary using Spring &amp; Hibernate
Timeline: 7 weeks and a half after day 0 (starting Java)
Duration: 3 days

Tags: Java, Spring (MVC, controller, mappings, annotations, dependency injection, requests), Hibernate (ORM, DAO), Maven, JS jQuery, AJAX, HTML

Notes: Based on SimpleDictionary, but implemented with tools above

Intrebari:


1. In controller am un camp pentru obiectul Dictionary:
    private Dictionary myDictionary = new Dictionary();
  Cum pot face sa mi-l trag in metoda wordSubmit cu getBean, daca il declar ca <bean> in Dictionary-servlet.xml?
  
  Fiind anotat cu @Controller, stiu ca isi cauta contextul by default in Dictionary-servlet.xml.
  Dar nu stiu cum pot sa apelez contextul (cum ai face intr-o applicatie classica cu ApplicationContext.getBean()).

R: Nu se foloseste getBean, ci @Autowired. Daca campul/proprietatea declarat/a are @Autowire deasupra, Spring cauta sa ii atribuie bean-ul declarat in xml.
  
2. In clasa Dictionary initializez un hibernate sessionFactory in constructor.
    Sincer nu cred ca asa se face, dar nici nu am gasit un model pe net.
    
    Pot face cumva sa il am ca <bean> in Dictionary-servlet.xml si sa il folosesc ca <property> pentru bean-ul Dictionary?
    E indicat asa?

R: Da. Se poate face in 2 moduri sigur:
    - fie declarand si SessionFactory si Dictionary ca beans, implementat setter pentru Dictionary si injectand proprietatea din Dictionary cu bean-ul SessionFactory
    - fie declarand si SessionFactory si Dictionary ca beans, apoi utilizand @Autowired deasupra declararii campului/proprietatii SessionFactory din Dictionary. Avantajul este ca nu mai e nevoie a se implementa setter.
    
3. Poti sa te uiti putin la structura pe directoare a proiectului? Ti se pare ok?

    Am citit putin despre Spring MVC si am incercat sa respect anumite lucruri:
      - model => Word
      - view => search.jsp
      - controller => DictionaryController
    
    Dar facand, am vazut ca asta nu e tot. Folosind Hibernate, folosesti si DAO.
    Insa pe net, lumea recomanda ca partea de tranzactie sa nu fie implementata in DAO, ci in Service layer.
    Acum eu am facut un director services cu Dictionary.java, in care implementez partea de tranzactie.
    
    Daca ar fi sa fie ca la carte, ordonat, ti se pare ca structura e buna? Asa se intalneste si in practica?
    Sau ma complic prea mult gandindu-ma la asta?
    
4. Incerc sa implementez autocomplete.
	La fel ca si fara Spring, trebuie sa includ cumva fisierul JavaScript ca <script> in JSP.
	
	a.
	Daca procedez ca data trecuta, ar trebui sa pot plasa fisierul JS in src/main/webapp si sa mearga doar cu <script src="searchautocomplete.js"></script> plasat in JSP.
	Ce nu inteleg e de ce, in cazul asta, nu imi gaseste fisierul JS (404 not found)?

R pt a: Rezolvat. Trebuie adaugat si <mvc:default-servlet-handler />. When using of the default servlet mapping it is also recommended to add this to your Spring MVC configuration, which ensures that any resource requests not handled by your Spring MVC mappings will be delegated back to the Servlet container. 
http://docs.spring.io/spring-webflow/docs/current-SNAPSHOT/reference/html/spring-js.html

	
	b.
	Am citit ca e best practice sa tii fisierele JS, CSS etc. intr-un director src/main/webapp/resources si sa folosesti ceva de tipul <mvc:resources location="/js/**" mapping="/, classpath:/main/webapp/resources/js/"/> in fisierul xml al servlet-ului.
	Ce e ciudat e ca, daca pun linia asta in xml, cand rulez applicatia, nu imi mai gaseste http://localhost:8080/Dictionary/search (404 not found). De ce?

R pt b: Rezolvat problema prin a adauga <mvc:annotation-driven/>. Explicatia scurta --- Since <mvc:resources> adds its own handler mapping, defaults are broken, therefore other handler mappings should be decalred explicitly, either by <mvc:annotation-driven> or manually as beans. https://stackoverflow.com/questions/4057529/using-mvcresources-in-spring-3-causes-all-other-views-to-stop-working/4058607#4058607?newreg=448d3fcc8638480981ef65db3125230b
