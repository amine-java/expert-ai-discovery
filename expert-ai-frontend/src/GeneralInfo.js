
import { Badge, Container, Table } from 'reactstrap';
import {Component} from 'react';
export default class GeneralInfo extends Component{

    state = {
        sentiment: this.props.sentiment,
        filename: this.props.filename,
        date: this.props.date
    }

    render() {
        return (
            <div>
                <Container fluid>
                    <h3>General Information</h3><br/>
                    <Table striped bordered hover>
                        <thead>
                        <tr>
                            <th width="40%">File</th>
                            <th width="30%">Date Analyze</th>
                            <th width="30%">Sentiment </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td style={{whiteSpace: 'nowrap'}}>{this.state.filename}</td>
                            <td>{this.state.date}</td>
                            <td>{this.getBadge(this.state.sentiment.overall)}</td>
                         </tr>
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }

    getBadge(score){
        
        if (score>10){
           return <p>Good</p>;
        }
        
        if (score<0){
            return <p>Bad</p>;
        }

        return <p>Fine</p>;

    }
}
