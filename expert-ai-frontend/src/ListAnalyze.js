
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import {Component} from 'react';
export default class ListAnalyze extends Component{

    state = {
        files: this.props.files,
        onClick: this.props.onClick
    }

    render() {
        const {files} = this.state;

        const fileList = files.map(file => {
            return <tr key={file.id}>
                <td style={{whiteSpace: 'nowrap'}}>{file.fileName}</td>
                <td>
                <div className="float-right">
                    <Button color="success" on onClick={() => this.state.onClick(file.id)}> See Details</Button>
                </div>
                </td>
            </tr>
        });

        return (
            <div>
                <Container fluid>
                    <h3>Analyzed Files</h3><br/>
                    <Table striped bordered hover>
                        <thead>
                        <tr>
                            <th width="70%">Filename</th>
                            <th width="50%">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        {fileList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }

}
