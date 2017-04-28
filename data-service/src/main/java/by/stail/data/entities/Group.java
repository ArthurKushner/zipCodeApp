package by.stail.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @autor Arthur Kushner
 * @since 4/28/17
 */
@Document(collection = "userGroups")
public class Group {

    @Id
    String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
