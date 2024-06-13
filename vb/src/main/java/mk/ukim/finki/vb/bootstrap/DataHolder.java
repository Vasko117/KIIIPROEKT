//package mk.ukim.finki.vb.bootstrap;
//
//import jakarta.annotation.PostConstruct;
//import mk.ukim.finki.vb.model.Author;
//import mk.ukim.finki.vb.model.Book;
//import mk.ukim.finki.vb.model.Bookstore;
//import mk.ukim.finki.vb.model.emt.*;
//import mk.ukim.finki.vb.repository.emt.CountryRepo;
//import mk.ukim.finki.vb.repository.emt.HostRepo;
//import mk.ukim.finki.vb.repository.emt.KorisnikRepo;
//import mk.ukim.finki.vb.repository.emt.SmestuvanjeRepo;
//import mk.ukim.finki.vb.repository.jpa.AuthJpaRepository;
//import mk.ukim.finki.vb.repository.jpa.BookJpaRepository;
//import mk.ukim.finki.vb.repository.jpa.BookStoreJpaRepository;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DataHolder {
//    private final AuthJpaRepository authJpaRepository;
//    private final BookStoreJpaRepository bookStoreJpaRepository;
//    private final BookJpaRepository bookJpaRepository;
//    private final KorisnikRepo korisnikRepo;
//
//    private final HostRepo hostRepo;
//    private final SmestuvanjeRepo smestuvanjeRepo;
//    private final CountryRepo countryRepo;
//
//    public static List<Author> authors=new ArrayList<>();
//    public static List<Book> books=new ArrayList<>();
//    public static List<Bookstore> bookstores=new ArrayList<>();
//
//    public static List<Host> hosts=new ArrayList<>();
//    public static List<Smestuvanje> places=new ArrayList<>();
//    public static List<Country> countries=new ArrayList<>();
//    public static List<Korisnik> korisniks=new ArrayList<>();
//
//    public DataHolder(AuthJpaRepository authJpaRepository, BookStoreJpaRepository bookStoreJpaRepository, BookJpaRepository bookJpaRepository, KorisnikRepo korisnikRepo, HostRepo hostRepo, SmestuvanjeRepo smestuvanjeRepo, CountryRepo countryRepo) {
//        this.authJpaRepository = authJpaRepository;
//        this.bookStoreJpaRepository = bookStoreJpaRepository;
//        this.bookJpaRepository = bookJpaRepository;
//        this.korisnikRepo = korisnikRepo;
//        this.hostRepo = hostRepo;
//        this.smestuvanjeRepo = smestuvanjeRepo;
//        this.countryRepo = countryRepo;
//    }
//
//    @PostConstruct
//    public void init() {
//        if(hosts.size()==0 && countries.size()==0 && places.size()==0)
//        {
//            Country c1=new Country("Germany","Europe");
//            Country c2=new Country("Ohio","America");
//            Country c3=new Country("France","Europe");
//            Country c4=new Country("Serbia","Europe");
//            Country c5=new Country("Croatia","Europe");
//            countries.add(c1);
//            countries.add(c2);
//            countries.add(c3);
//            countries.add(c4);
//            countries.add(c5);
//            Host h1=new Host("Kristijan","Panchevski",c1);
//            Host h2=new Host("Dimitrij","Krstev",c2);
//            Host h3=new Host("Bojana","Jancheska",c3);
//            Host h4=new Host("Viktor","Vasilev",c4);
//            Host h5=new Host("Vasil","Strezov",c5);
//            hosts.add(h1);
//            hosts.add(h2);
//            hosts.add(h3);
//            hosts.add(h4);
//            hosts.add(h5);
//            places.add(new Smestuvanje(Category.ROOM,3,h1));
//            places.add(new Smestuvanje(Category.HOTEL,2,h2));
//            places.add(new Smestuvanje(Category.APARTMENT,1,h3));
//            places.add(new Smestuvanje(Category.FLAT,5,h4));
//            places.add(new Smestuvanje(Category.MOTEL,1,h5));
//            countryRepo.saveAll(countries);
//            hostRepo.saveAll(hosts);
//            smestuvanjeRepo.saveAll(places);
//        }
//        if(korisniks.size()==0) {
//            korisniks.add(new Korisnik("Nikola", "Pendev"));
//            korisniks.add(new Korisnik("Luka", "Pecijarev"));
//            korisniks.add(new Korisnik("Ace", "Filiposki"));
//            korisniks.add(new Korisnik("Willy", "Wonka"));
//            korisniks.add(new Korisnik("Nikolina", "Ivanova"));
//            korisnikRepo.saveAll(korisniks);
//        }
//    }
//}