package Interface;

public class Show implements Tickets 
{

	public static void main(String[] args)
	{
		Show s=new Show();
		s.Interval();
		s.BookingTickets();
		s.Movie();
	Tickets t=new Show();
	
	}

	@Override
	public void Movie() 
	{
	
		System.out.println("moviebuff");
		
	}

	@Override
	public void Interval() 
	{
		System.out.println("TicketsCounter");
		
	}

	@Override
	public void BookingTickets() 
	
	{
		System.out.println("Showtime");
	}

}
