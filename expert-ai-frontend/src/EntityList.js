
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import {Component} from 'react';
export default class EntityList extends Component{

    state = {
        entities: this.props.entities
    }

    render() {
        const {entities} = this.state;

        const entityList = entities.map(entity => {
            return <tr key={entity.id}>
                <td style={{whiteSpace: 'nowrap'}}>{entity.type}</td>
                <td>{entity.lemma}</td>
            </tr>
        });

        return (
            <div>
                <Container fluid>
                    <h3>Entities</h3><br/>
                    <Table striped bordered hover>
                        <thead>
                        <tr>
                            <th width="50%">Type</th>
                            <th width="50%">Lemma</th>
                        </tr>
                        </thead>
                        <tbody>
                        {entityList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}
