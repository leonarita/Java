package II_Orientada_A_Objetos;

public class TV {
	String fabricante = "Sony";
	int polegadas = 32;
	int volume = 0;
	int canal = 1;
	boolean ligado = false;
	
	public void aumentarVolume()
	{	if (volume>=10)
			return;
		volume++;		}
	
	public void diminuirVolume()
	{	if (volume<=0)
			return;
		volume--;		}
	
	public void ligar()
	{	ligado=true;	}
	
	public void desligar()
	{	ligado=false;	}
}