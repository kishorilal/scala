class Demo{
	public static void main(String args[])
	{
		System.out.println("Advance data structure"+fastPow(2,4));
	
	}
	
	static int fastPow(int a,int b)
	{
		if(b==0)
			return 1;
		if(b%2==0)
			return fastPow(a*a,b/2);
		return a*fastPow(a,b-1);
			
}


}
