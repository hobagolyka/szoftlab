/**
 * Created by Judit on 2016. 04. 23..
 */
public class Replicator implements Movable {
    private Floor position;
    private Direction direction;

    @Override
    public void step() { }

    @Override
    public void setPosition(Floor position) {
        this.position = position;
    }

    @Override
    public Floor getPosition() {
        return position;
    }

    public void die(){}
}
