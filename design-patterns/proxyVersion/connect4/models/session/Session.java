package proxyVersion.connect4.models.session;

import proxyVersion.connect4.models.StateValue;
import proxyVersion.connect4.types.Color;
import proxyVersion.utils.models.ConcreteCoordinate;

public interface Session {

    StateValue getValueState();

    Color getColor(ConcreteCoordinate coordinate);
}
