/*
 *Blue Team's Recommendation Engine
 *Data comparison and crawler
 */
package recommendation;

import static java.lang.Math.abs;
import java.util.LinkedList;
import java.util.List;

/**
 * This work is done By Chris Berns Northern Essex Community College Computer
 * Science II Prof. Russ Gouveia
 */
public class Recommendation {

    /**
     */
    public static class Crawler {

        float worstMatch;
        User user;

        public Crawler(User user, LinkedList<Book> bookList) {
            this.user = user;
            user.printUserPrefs();
            while (!bookList.isEmpty()) {
                Book crntBook = bookList.remove();
                crntBook.getBookRating().printRatings();
                System.out.println(getMatch(crntBook));
                //bookList add to back / also needs to have sentinel 
                //Books should be a circular linked list
            }
        }

        private float getMatch(Book book) {
            float match = 0;
            book.getBookRating().printRatings();
            for (int i = 0; i < 2; i++) {
                if (user.getUserPref()[i] < 0) {
                    System.out.println(user.getUserPref()[i]);
                    match += abs(user.getUserPref()[i] + book.getBookRating().getRatingMatrix()[1][i]);
                } else {
                    System.out.println(user.getUserPref()[i]);
                    System.out.println("@" + book.getBookRating().getRatingMatrix()[1][i]);
                    match += (user.getUserPref()[i] - book.getBookRating().ratingMatrix[1][i]);
                }
            }
            return match;
        }

    }

    public static void main(String[] args) {
        Book book = new Book();

        float[][] bookRatingMatrix = {{5.0f, 5.0f, 5.0f},
        {0.0f, 0.0f, 0.0f}};

        float[] userPrefMatrix = {5.0f, -5.0f, 5.0f};
        book.getBookRating().setRating(bookRatingMatrix);
        User user = new User(userPrefMatrix);

   
        //book.getBookRating().printRatings();
       // user.printUserPrefs();
        LinkedList<Book> books = new LinkedList<>();
        books.add(book);
        Crawler crawl = new Crawler(user, books);

    }
}
