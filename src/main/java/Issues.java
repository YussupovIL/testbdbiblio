import com.sun.org.apache.xpath.internal.operations.String;

/**
 * Created by Владелец on 03.04.2017.
 */
public class Issues {

    private int id;
    private String title;
    private String author;
    private String description;
    private String publisher;

    public Issues(String title,String author, String description, String publisher ){
        this.title = title;
        this.author = author;
        this.description = description;
        this.publisher = publisher;
    }

    public int getID(){
        return id;
    }

    public void setId(int id){
        this.id = id;

    }

    public String getAuthor(){
        return author;
    }

    public String getPublisher(){
        return publisher;
    }
    public String getDescription(){
        return description;
    }
    public String getTitle(){
        return title;
    }

    public void setAuthor(String author){
        this.author = author;

    }

    public void setTitle(String title){
        this.title = title;

    }

    public void setDescription(String description){
        this.description = description;

    }

    public void setPublisher(String publisher){
        this.publisher = publisher;

    }


}
