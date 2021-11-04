
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import {Component} from 'react';
export default class TopicList extends Component{

    state = {
        topics: this.props.topics
    }

    render() {
        const {topics} = this.state;

        const topicList = topics.map(topic => {
            return <tr key={topic.id}>
                <td style={{whiteSpace: 'nowrap'}}>{topic.label}</td>
                <td>{topic.score}</td>
            </tr>
        });

        return (
            <div>
                <Container fluid>
                    <h3>Topics</h3><br/>
                    <Table striped bordered hover>
                        <thead>
                        <tr>
                            <th width="60%">Label</th>
                            <th width="40%">Score</th>
                        </tr>
                        </thead>
                        <tbody>
                        {topicList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}
