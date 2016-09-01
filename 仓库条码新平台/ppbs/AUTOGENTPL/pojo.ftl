package cc.jiuyi.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import org.compass.annotations.Searchable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 *
 * 实体类-${NameDes}
 * 
 * @author welson
 * @version 1.0
 */


@Entity
@Searchable
@Table(name = "${Name}")
public class ${Name} extends BaseEntity {

	private static final long serialVersionUID = -6109590619136943215L;
	
//{autoCode}
//{autoCode_Modify}
	

}