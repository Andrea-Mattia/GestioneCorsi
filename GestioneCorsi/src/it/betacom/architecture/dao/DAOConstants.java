package it.betacom.architecture.dao;

public interface DAOConstants {
		
	/*############################################--ADMIN--############################################*/
	String SELECT_ADMINPASS = "Select password from amministratore where cod_admin = ?";
	String SELECT_ADMIN_NAME = "select nomeadmin from amministratore";
	
		
	/*############################################--DOCENTE--############################################*/
	String SELECT_DOCENTI = "select * from docente";
	
	String DELETE_DOCENTE = "delete from docente where cod_docente = ?";
	
	
	/*############################################--CORSO--############################################*/
	String SELECT_DATE_CORSO = "select datainizio, datafine from corso";
	
	String SELECT_CORSO = "select * from corso";
	
	String SELECT_CORSO_SEQ = "select corso_seq.nextval from dual";
	
	String DELETE_CORSO = "delete from corso where cod_corso = ?";
	
	String UPDATE_CORSO = "update corso set datainizio = ?, datafine = ?, costocorso = ?, commenticorso = ?, aulacorso = ? where cod_corso = ?";
	
	
	/*############################################--CORSISTA--############################################*/
	String SELECT_CORSISTA = "select * from corsista";
	
	String SEARCH_CORSISTA = "select * from corsista where LOWER(nomecorsista) like '%'||?||'%' and LOWER(cognomecorsista) like '%'||?||'%'";
	
	String SELECT_CORSISTA_SEQ = "select corsista_seq.nextval from dual";
	
	String DELETE_CORSISTA = "delete from corsista where cod_corsista = ?";
	
	String UPDATE_CORSISTA = "update corsista set nomecorsista = ?, cognomecorsista = ?, precedentiformativi = ? where cod_corsista = ?";
	
	String SELECT_CORSISTA_BYID = "select * from corsista where cod_corsista = ?";
	
	/*############################################--CORSISTA_CORSO--############################################*/
	String SELECT_CORSISTA_NUM = "select count(*) from corsista";
	
	String SELECT_CORSISTA_CORSO = "select * from corsista_corso";
	
	String DELETE_CORSISTA_CORSO = "delete from corsista_corso where cod_corso = ? and cod_corsista = ?";
		
	
	/*############################################--UTILITIES--############################################*/

	String SELECT_CORSISTA_SUM = "select count(*) from corsista coa\r\n"
			+ "join corsista_corso cc on cc.cod_corsista = coa.cod_corsista\r\n"
			+ "where cc.cod_corso in (select cor.cod_corso from corso cor where sysdate <= cor.datafine and sysdate >= cor.datainizio)";
	
	String SELECT_LAST_COURSE = "select * from corso where (select max(datainizio) from corso) = datainizio ";
	
	String SELECT_COMMENT_SUM = "select count(*) from corso where commenticorso is not null";
	
	String SELECT_MULTI_COURSES = "select distinct d.nomedocente, d.cognomedocente, d.cod_docente from docente d \r\n"
			+ "inner join corso c on d.cod_docente = c.cod_docente \r\n"
			+ "where (select count(*) from corso \r\n"
			+ "where corso.cod_docente = d.cod_docente) > 1";
	
	String SELECT_AVAILABLE_COURSES = "select corso.cod_corso, corso.nomecorso,corso.datainizio, corso.costocorso from corso \r\n"
			+ "where sysdate < corso.datainizio and \r\n"
			+ "(select count(*) from corsista_corso where corsista_corso.cod_corso = corso.cod_corso) < 12";
	
	String SELECT_POPULAR_COURSES = "select c.cod_corso, c.nomecorso, count(cc.cod_corsista) as tot_corsisti from corsista_corso cc \r\n"
			+ "join corso c on cc.cod_corso = c.cod_corso \r\n"
			+ "group by c.cod_corso, c.nomecorso \r\n"
			+ "order by tot_corsisti desc";
	
	String SELECT_CORSISTA_COURSES = "select * from corso c \r\n"
			+ "left join corsista_corso cc\r\n"
			+ "on c.cod_corso = cc.cod_corso\r\n"
			+ "where cc.cod_corsista = ?\r\n"
			+ "order by c.datainizio";
	
}
