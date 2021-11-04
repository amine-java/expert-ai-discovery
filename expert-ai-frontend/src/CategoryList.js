
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import {Component} from 'react';
export default class CategoryList extends Component{

    state = {
        categories: this.props.categories
    }

    render() {
        const {categories} = this.state;

        const categoryList = categories.map(category => {
            return <tr key={category.id}>
                <td style={{whiteSpace: 'nowrap'}}>{category.label}</td>
                <td>{category.score}</td>
                <td>{category.frequency}</td>
            </tr>
        });

        return (
            <div>
                <Container fluid>
                    <h3>Categories</h3><br/>
                    <Table striped bordered hover>
                        <thead>
                        <tr>
                            <th width="40%">Label</th>
                            <th width="30%">Score</th>
                            <th width="30%">Frequency</th>
                        </tr>
                        </thead>
                        <tbody>
                        {categoryList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}
