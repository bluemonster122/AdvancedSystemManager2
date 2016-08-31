package gigabit101.AdvancedSystemManager2.components;


import gigabit101.AdvancedSystemManager2.CollisionHelper;
import gigabit101.AdvancedSystemManager2.interfaces.GuiManager;
import gigabit101.AdvancedSystemManager2.settings.Settings;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class CheckBoxList
{
    public static final int CHECK_BOX_SIZE = 8;
    private static final int CHECK_BOX_SRC_X = 42;
    private static final int CHECK_BOX_SRC_Y = 106;
    private static final int CHECK_BOX_TEXT_X = 12;
    private static final int CHECK_BOX_TEXT_Y = 2;

    private List<CheckBox> checkBoxes;

    public CheckBoxList()
    {
        checkBoxes = new ArrayList<CheckBox>();
    }

    public void addCheckBox(CheckBox checkBox)
    {
        checkBoxes.add(checkBox);
    }

    @SideOnly(Side.CLIENT)
    public void draw(GuiManager gui, int mX, int mY)
    {
        for (CheckBox checkBox : checkBoxes)
        {
            if (checkBox.isVisible())
            {
                int srcCheckBoxX = checkBox.getValue() ? 1 : 0;
                int srcCheckBoxY = CollisionHelper.inBounds(checkBox.getX(), checkBox.getY(), CHECK_BOX_SIZE, CHECK_BOX_SIZE, mX, mY) ? 1 : 0;

                gui.drawTexture(checkBox.getX(), checkBox.getY(), CHECK_BOX_SRC_X + srcCheckBoxX * CHECK_BOX_SIZE, CHECK_BOX_SRC_Y + srcCheckBoxY * CHECK_BOX_SIZE, CHECK_BOX_SIZE, CHECK_BOX_SIZE);
                if (checkBox.getName() != null)
                {
                    int colour;
                    if (Settings.isDarkMode())
                        colour = 0x904040;
                    else
                        colour = 0x404040;
                    gui.drawSplitString(checkBox.getName(), checkBox.getX() + CHECK_BOX_TEXT_X, checkBox.getY() + CHECK_BOX_TEXT_Y, checkBox.getTextWidth(), 0.7F, colour);
                }
            }
        }
    }

    public void onClick(int mX, int mY)
    {
        for (CheckBox checkBox : checkBoxes)
        {
            if (checkBox.isVisible() && CollisionHelper.inBounds(checkBox.getX(), checkBox.getY(), CHECK_BOX_SIZE, CHECK_BOX_SIZE, mX, mY))
            {
                checkBox.setValue(!checkBox.getValue());
                checkBox.onUpdate();
                break;
            }
        }
    }
}
