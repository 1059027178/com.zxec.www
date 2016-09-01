<?xml version="1.0" encoding="UTF-8" ?>

<!DOCTYPE sqlMap
    PUBLIC "-//ibatis.apache.org//DTD SQL Map 2.0//EN"
    "http://ibatis.apache.org/dtd/sql-map-2.dtd">

<sqlMap namespace="${Name}">

  <!-- Use type aliases to avoid typing the full classname every time. -->
  <typeAlias alias="${Name}" type="com.quanhai.${project}.business.domains.${Name}"/>

  <!-- Result maps describe the mapping between the columns returned
       from a query, and the class properties.  A result map isn't
       necessary if the columns (or aliases) match to the properties
       exactly. 
       -->
  <resultMap id="${Name}Result" class="${Name}">
    <result property="${Lname}Id" column="${Lname}Id"/>  
//{autoCode1}
  </resultMap>
  
  
  <cacheModel id="${Lname}-cache"  type="LRU"> 
	 <flushInterval hours="24"/> 
	 <flushOnExecute statement="create${Name}"/> 
	 <flushOnExecute statement="update${Name}"/> 
	 <flushOnExecute statement="delete${Name}"/> 
	 <flushOnExecute statement="delete${Name}ByIds"/> 
	 <property name="size" value="1000" /> 
</cacheModel> 

  <select id="get${Name}ById" parameterClass="String" resultClass="${Name}" cacheModel="${Lname}-cache">
    select A.${Lname}Id,
//{autoCode2}
 from ${Name} A where A.${Lname}Id = #${Lname}Id#
  </select>
  
  
    <!-- goodsQueryClause definition-->
  	<sql id="${Lname}QueryClause">
    <dynamic>
			<isNotNull prepend="AND" property="${Lname}Id">
				(A.${Lname}Id = #${Lname}Id#)
			</isNotNull>
		</dynamic>
	</sql>
	
  <sql id="pageSQL${Name}">
	  	ORDER BY $sort$ $sdir$ LIMIT $skip$,$limit$
	</sql>
    
  <select id="getAll${Name}s" resultMap="${Name}Result" parameterClass="Map" resultClass="List" cacheModel="${Lname}-cache">
    select A.${Lname}Id,
//{autoCode3}
 from ${Name} A where A.isDel = 'N'
    <include refid="${Lname}QueryClause"/>	
    <include refid="pageSQL${Name}" />
  </select>
  

	
  <select id="getAll${Name}sCount" resultClass="int" cacheModel="${Lname}-cache">
    select COUNT(*) from ${Name} A where A.isDel = 'N'
    <include refid="${Lname}QueryClause"/>
  </select>
    
  <insert id="create${Name}" parameterClass="${Name}">
    insert into ${Lname} (
      ${Lname}Id,
//{autoCode4}
    ) values (
      #${Lname}Id#,
//{autoCode5}
    )
  </insert>
  
  <delete id="delete${Name}" parameterClass="String">
     update ${Lname} set isDel = 'Y'  where ${Lname}Id = #${Lname}Id#
  </delete>

  <update id="update${Name}" parameterClass="${Name}">
      update ${Lname} set      
//{autoCode6}
    where
      ${Lname}Id = #${Lname}Id#
  </update>
  
  <delete id="delete${Name}ByIds"  parameterClass="List">
      update ${Lname} set isDel = 'Y' where ${Lname}Id in 
      <iterate open="(" close=")" conjunction=",">  
        #values[]#
     </iterate> 
    </delete>  
  
  
  
</sqlMap>


