package gigabit101.AdvancedSystemManager2.components;

import gigabit101.AdvancedSystemManager2.Localization;
import gigabit101.AdvancedSystemManager2.blocks.ConnectionBlockType;

import java.util.List;


public class ComponentMenuCamouflage extends ComponentMenuContainer {
    public ComponentMenuCamouflage(FlowComponent parent) {
        super(parent, ConnectionBlockType.CAMOUFLAGE);
    }

    @Override
    public String getName() {
        return Localization.CAMOUFLAGE_BLOCK_MENU.toString();
    }

    @Override
    protected void initRadioButtons() {
        //nothing here
    }

    @Override
    public void addErrors(List<String> errors) {
        if (selectedInventories.isEmpty()) {
            errors.add(Localization.NO_CAMOUFLAGE_BLOCKS_ERROR.toString());
        }
    }
}
