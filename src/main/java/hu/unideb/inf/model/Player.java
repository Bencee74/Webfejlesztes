package hu.unideb.inf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "players")
public class Player {

    @Id
    private Long id;
    private String name;
    private int age;
    private String nationality;
    private String club;
    private int shirtNumber;
    private String position;
}