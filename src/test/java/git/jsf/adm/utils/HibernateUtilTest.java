package git.jsf.adm.utils;

import org.junit.jupiter.api.Test;

import git.jsf.adm.dao.DaoGeneric;
import git.jsf.adm.model.UsuarioPessoa;

public class HibernateUtilTest {

    @Test
    public void testHibernateUtil() {
	HibernateUtil.getEntityManager();
    }

    @Test
    public void testEntidadeSalvar() {
	DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

	UsuarioPessoa pessoa = new UsuarioPessoa();

	pessoa.setIdade(45);
	pessoa.setLogin("teste");
	pessoa.setNome("Davi");
	pessoa.setSenha("123");
	pessoa.setSobrenome("Olive");
	pessoa.setEmail("email@email.com");

	daoGeneric.salvar(pessoa);

    }

    @Test
    public void testeBuscar() {
	DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

	UsuarioPessoa pessoa = new UsuarioPessoa();
	pessoa.setId(1L);

	pessoa = daoGeneric.pesquisar(pessoa);

	System.out.println(pessoa);
    }

    @Test
    public void testeBuscar2() {
	DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

	UsuarioPessoa pessoa = daoGeneric.pesquisarOutraForma(1L,
		UsuarioPessoa.class);

	System.out.println(pessoa);
    }
    
    @Test
    public void testeUpdate() {
	DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
	
	UsuarioPessoa pessoa = daoGeneric.pesquisarOutraForma(1L,
		UsuarioPessoa.class);
	
	pessoa.setIdade(99);
	pessoa.setNome("New Name");
	
	pessoa = daoGeneric.updateMerge(pessoa);
	
	System.out.println(pessoa);
    }
    
    @Test
    public void testeDelete() {
	DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
	
	UsuarioPessoa pessoa1 = daoGeneric.pesquisarOutraForma(6L,
		UsuarioPessoa.class);
	UsuarioPessoa pessoa2 = daoGeneric.pesquisarOutraForma(7L,
		UsuarioPessoa.class);
	UsuarioPessoa pessoa3 = daoGeneric.pesquisarOutraForma(8L,
		UsuarioPessoa.class);

	daoGeneric.deletarPorId(pessoa1);
	daoGeneric.deletarPorId(pessoa2);
	daoGeneric.deletarPorId(pessoa3);
	
	System.out.println("Deletado com sucesso");
    }

}
