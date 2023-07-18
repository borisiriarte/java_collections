package collections_2;

import java.util.Comparator;
import java.util.TreeSet;

public class LinkedList_2 {
  public static void main( String[] args ) {
    TreeSet<String> people = new TreeSet<>();

    people.add( "John" );
    people.add( "Mary" );
    people.add( "Bob" );
    people.add( "Carlos" );

    for( String person: people ) {
      System.out.println(person);
    }

    Article  article1 = new Article( 1, "First Article" );
    Article  article2 = new Article( 10, "Second Article" );
    Article  article3 = new Article( 3, "Third Article" );

    TreeSet<Article> articles = new TreeSet<>();

    articles.add( article1 );
    articles.add( article2 );
    articles.add( article3 );

    for( Article article : articles ) {
      System.out.println(article.getDescription());
    }

    /*Article comparator = new Article();

    TreeSet<Article> sortedArticles = new TreeSet<>( comparator );*/

    //ArticleComparator compareArticles = new ArticleComparator();
    TreeSet<Article> sortedArticles = new TreeSet<>( new Comparator<Article>(){
      @Override
      public int compare( Article o1, Article o2 ) {
        String description1 = o1.getDescription();
        String description2 = o2.getDescription();
        return description1.compareTo( description2 );
      }
    });

    sortedArticles.add( article1 );
    sortedArticles.add( article2 );
    sortedArticles.add( article3 );

    for( Article article : sortedArticles ) {
      System.out.println(article.getDescription());
    }
  }
}

class Article implements Comparable<Article>{
  private int num;
  private String description;

  public Article( int num, String description ) {
    this.num = num;
    this.description = description;
  }

  public String getDescription() {
    return description;
  }


  public int compareTo( Article other ) {
    return num - other.num;
  }

}

/*class ArticleComparator implements Comparator<Article>{

  @Override
  public int compare( Article o1, Article o2 ) {
    String description1 = o1.getDescription();
    String description2 = o2.getDescription();

    return description1.compareTo( description2 );
  }
}*/

