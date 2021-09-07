package metaprogramming.cap3.ex4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapeamentoParametros<E> {

	private Map<String, Field> parametros;
	private Class<E> clazz;
	
	public MapeamentoParametros(Class<E> c) {
		parametros = new HashMap<>();
		clazz = c;
		Class<?> current = c;
		
		while (current != Object.class) {
			for (Field f : current.getDeclaredFields()) {
			
				if (f.isAnnotationPresent(Parametro.class)) {
					Parametro p = f.getAnnotation(Parametro.class);
					parametros.put(p.value(), f);
				}
			}
				
			current = current.getSuperclass();
		}
	}
	
	private Method getSetter(Field f) throws Exception {
		String nomeMetodo = "set" + Character.toUpperCase(f.getName().charAt(0)) + f.getName().substring(1);
		
		for(Method m : clazz.getMethods()){
			if(m.getName().equals(nomeMetodo))
				return m;
		}
		
		throw new Exception(nomeMetodo +"() não encontrado");
	}
	
	private void inserir(E instancia, String nomeParametro, List<String> valores) throws Exception {
		Field f = parametros.get(nomeParametro);
		
		if(f == null){
			throw new Exception(nomeParametro + ": parâmetro não previsto");
		}
		
		Method m = getSetter(f);
		Object valor = recuperarValor(nomeParametro, valores, m);
	
		try {
			m.invoke(instancia, valor);
		} catch (Exception e) {
			throw new Exception("Problemas ao invocar " + m.getName(), (Throwable) e);
		}
	}
	
	private Object recuperarValor(String nomeParametro, List<String> valores, Method m) throws Exception {
			
		if(m.getParameterTypes()[0] == boolean.class || m.getParameterTypes()[0] == Boolean.class) {
	
			if(valores.size() > 0){
				throw new Exception(nomeParametro + " não pode possuir valor");
			}
			else {
				return true;
			}
		}
		else if(m.getParameterTypes()[0].isArray()) { 
			return valores.toArray(new String[valores.size()]);
		}
		else {
			
			if(valores.size() != 1){
				throw new Exception(nomeParametro + " só pode possuir um valor");
			}
			else {
				return valores.get(0);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public E mapear(String[] args) throws Exception{
		String nomeParametro = null;
		List<String> valores = new ArrayList<>();
		
		E instancia = null;
		
		try {
			instancia = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new Exception(clazz.getName() + " não pode ser instanciada", e);
		}
		
		for (int i = 0; i < args.length; i++) {
			String token = args[i];
		
			if (token.startsWith("-")) {
				nomeParametro = token;
			} 
			else {
				valores.add(token);
			}
		
			if (args.length == i + 1 || args[i + 1].startsWith("-")) {
				inserir(instancia, nomeParametro, valores);
				nomeParametro = null;
				valores.clear();
			}
		}
		
		return instancia;
	}
	
}
