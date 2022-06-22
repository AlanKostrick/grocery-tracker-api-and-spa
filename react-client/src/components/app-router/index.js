import { Route, Switch } from 'react-router-dom';

import Contact from '../../pages/contact';
import Home from '../../pages/home';
import React from 'react';

const PageSwitch = () => (
    <Switch>
        <Route exact path={'/'} component={Home} />
        <Route exact path={'/contact'} component={Contact} />
    </Switch>

);

export default PageSwitch;