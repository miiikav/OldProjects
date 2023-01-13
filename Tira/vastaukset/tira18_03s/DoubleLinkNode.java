
class DoubleLinkNode
{
    public DoubleLinkNode (Object o)
    {
	   data = o;
	   // next ja prev alustuvat automaattisesti null-arvoksi
    }
    public Object data;
    public DoubleLinkNode next;
    public DoubleLinkNode prev;
}
