package combeat.beatbash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "festivals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Festival {
    @Id
    private ObjectId id;
    private String festivalId;
    private String name;
    private String country;
    private String city;
    private List<String> images;
    private List<String> genres;

    @DocumentReference
    private List<Review> reviews;

}
