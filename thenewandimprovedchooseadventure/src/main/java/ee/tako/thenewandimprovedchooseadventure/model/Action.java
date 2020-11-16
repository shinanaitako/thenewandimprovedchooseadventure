package ee.tako.thenewandimprovedchooseadventure.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "actions")
@AllArgsConstructor
public class Action extends BaseEntity {

	@Column
	private String name;

	@Column
	private String choice;

	@Column
	private String description;

	@Column
	private String result;

	@Column(name = "monster_id")
	private Long monsterId;

	public Action() {}
}

