package teste;

import java.util.Objects;

public class TesteClasses {
	
	private static class ClassToClone implements Cloneable {
		int i;

		public void setI(int i) {
			this.i = i;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ClassToClone other = (ClassToClone) obj;
			if (i != other.i)
				return false;
			return true;
		}

		@Override
		protected ClassToClone clone() throws CloneNotSupportedException {
			
			try {
	            return (ClassToClone) super.clone();
	        } catch (CloneNotSupportedException e) {
	            System.out.println (" Cloning not allowed. " );
	            return this;
	        }
		}
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		
		System.out.println(Objects.isNull(null));
		System.out.println(Objects.nonNull(null));
		
		ClassToClone c = new ClassToClone();
		c.setI(1);
		
		ClassToClone c2 = c.clone();
		c2.setI(2);
		
		System.out.println();
		System.out.println(c.equals(c2));
	}
}
