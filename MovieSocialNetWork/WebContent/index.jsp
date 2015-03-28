<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.neu.CS5200.msn.ds.dao.*,edu.neu.CS5200.msn.ds.entity.*,java.util.*, java.sql.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1> Hello World</h1>
    <%
    MovieManager moviemanager = new MovieManager();
     Date d =new Date(23/9/1991);
//     Movie movie1 = new Movie("123","Titanic","Tom and Jerry", d); 
//     out.println(movie1);
//     //moviemanager.createMovie(movie);
//     Movie movie2 = new Movie("124","Avantar","Blue people", d); 
//     out.println(movie2);
//     moviemanager.createMovie(movie2);
//     Movie movie3 = new Movie("125","Matrix","Hacker", d); 
//     out.println(movie3);
//     moviemanager.createMovie(movie3);
//     List<Movie> movies =  moviemanager.readAllMovies() ;
//     out.println(movies);
   
//     Movie movie2 = new Movie("124","Avantar","new Blue people", d); 
//     moviemanager.updateMovie("124",movie2);
//     Movie movie = moviemanager.readMovie("124");
//     out.println(movie);
//     moviemanager.deleteMovie("123");
//     out.println("-----------");
//     List<Movie> moviesnew =  moviemanager.readAllMovies() ;
//     out.println(moviesnew);
//       UserManager um = new UserManager();
//        User user1 = new User("Marry","123","Marry","Wonderland", "Marry@gmail.com",d);
//        User user2 = new User("Dan","123","Dan","Frank", "Dan@gmail.com",d);
//        User user3 = new User("Alice","123","Alice","Lee", "Alice@gmail.com",d);
//        um.createUser(user1);
//        um.createUser(user2);
//        um.createUser(user3);
//        List<User> users =  um.readAllUsers();
//        out.println(users);
//        User user = um.readUser("Dan");
//        out.println(user);
//        user.setEmail("new Email");
//        um.updateUser("Dan", user);
//        user = um.readUser("Dan");
//        out.println(user);
//        ActorManager am = new ActorManager();
//        Actor a1 = new Actor("1","Marry","Wonderland",d);
//        Actor a2 = new Actor("2","Dan","Wonderland",d);
//        Actor a3 = new Actor("3","Alice","Wonderland",d);
//        am.createActor(a1);
//        am.createActor(a2);
//        am.createActor(a3);
//        List<Actor> actors =  am.readAllActors();
//        out.println(actors);
//        Actor actor = am.readActor("2");
//        out.println(actor);
//        actor.setLastName("newName");
//        am.updateActor("2", actor);
//        actor = am.readActor("2");
//        out.println(actor);
         CastManager am = new CastManager();
//         Cast a1 = new Cast("1","1","124","Queen");
//         Cast a2 = new Cast("2","2","124","King");
//         Cast a3 = new Cast("3","3","124","Prince");
//         am.createCast(a1);
//         am.createCast(a2);
//         am.createCast(a3);
        List<Cast> actors =  am.readAllCastsForActor("2");
//        out.println(actors);
//         Cast Cast = am.readCastForId("2");
//         out.println(Cast);
//         Cast.setCharacterName("Welldone");
//         am.updateCast("2", Cast);
//         Cast = am.readCastForId("2");
//         out.println(Cast);
      actors =  am.readAllCastsForMovie("124");
      out.println(actors);
      am.deleteCast("2");



    %>



</body>
</html>