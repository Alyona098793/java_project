package wood.model;

public abstract class AbstractForm implements IWeight {
    protected Wood wood;

    public AbstractForm(Wood wood) {
        this.wood =wood;
    }

    public AbstractForm() {

    }


    public Wood getWood() {
        return wood;
    }

    //визначення ваги бруса
    @Override
    public float weight() {
        return wood.getDensity() * volume();
    }

    public abstract float volume();
}
