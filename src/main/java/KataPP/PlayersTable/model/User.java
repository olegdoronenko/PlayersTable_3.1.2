package KataPP.PlayersTable.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="players_party")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nickName;
    private String playerClass;
    private int playerLevel;

    public User(String nickName, String playerClass, int playerLevel) {
        this.nickName = nickName;
        this.playerClass = playerClass;
        this.playerLevel = playerLevel;
    }

}
