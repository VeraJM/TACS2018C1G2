import React, {Component} from 'react'
import {
    TableRow,
    TableRowColumn,
} from 'material-ui/Table';
import {List, ListItem} from 'material-ui/List';
import Dialog from 'material-ui/Dialog';
import FlatButton from 'material-ui/FlatButton';
import RaisedButton from 'material-ui/RaisedButton';
import ListadoTransacciones from './ListadoTransacciones.jsx';
import FontIcon from 'material-ui/FontIcon';


export default class Billetera extends Component {

    constructor(props) {
        super(props);
        this.state = {
            modalOpen: false
        }
    }

    toggle() {
        this.setState({modalOpen: !this.state.modalOpen});
    }

    render() {
        const {billetera} = this.props;
        const actions = [
            <FlatButton
                label="Cerrar"
                primary={true}
                onClick={this.toggle.bind(this)}
            />
        ];
        return (
            <TableRow>
                <TableRowColumn>{billetera.moneda.nombre}
                </TableRowColumn>
                <TableRowColumn>{billetera.cantidad}</TableRowColumn>
                <TableRowColumn>USD {billetera.moneda.corizacionActual || '100000'}</TableRowColumn>
                <TableRowColumn>USD <span>-400</span></TableRowColumn>
                <TableRowColumn>
                    <RaisedButton
                        label={
                            <FontIcon className="material-icons" title="Ver transacciones" color="white"
                                      style={{marginTop: "5px"}}>
                                monetization_on
                            </FontIcon>
                        }
                        onClick={this.toggle.bind(this)}
                        primary={true}
                        style={{width: "60px", minWidth: "0px"}}
                    />
                    <Dialog
                        title="Transacciones"
                        modal={false}
                        actions={actions}
                        open={this.state.modalOpen}
                        autoScrollBodyContent={true}
                        onRequestClose={this.toggle.bind(this)}
                    >
                        <ListadoTransacciones/>
                    </Dialog>
                </TableRowColumn>
            </TableRow>
        );
    }
}
