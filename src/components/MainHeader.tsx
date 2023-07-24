import { Component } from 'react';
import { AppBar, Toolbar } from "@mui/material";

interface MainHeaderProps {
    name : string;
}

interface MainHeaderState {

}

class MainHeader extends Component<MainHeaderProps, MainHeaderState> {

    constructor(props: MainHeaderProps) {
        super(props);

    }

    render() {
        return (
            <AppBar component={"nav"}>
                <Toolbar>
                    MUI
                </Toolbar>
            </AppBar>
        )
    }
}

export default MainHeader;
