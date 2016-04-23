/**
 * Created by Judit on 2016. 04. 23..
 */
public class WormholeYB {
    private static WormholeYB instance = new WormholeYB();

    private WormholeRG() { super();}

    public static WormholeRG getInstance()
    {
        Logger.enter(WormholeRG.class, "getInstance()", null);
        Logger.exit(WormholeRG.class, "getInstance()", null);

        return instance;
    }
}
