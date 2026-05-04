package cn.vonkun.core.menu;

public class MenuImplementor implements MenuAPI{
    @Override
    public CustomMenu createMenu(String title, int rows) {
        return new CoreMenu(title, rows);
    }
}
