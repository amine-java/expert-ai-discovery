import logo from './logo.svg';
import './App.css';
import {Component} from 'react';

import EntityList from './EntityList';
import CategoryList from './CategoryList';
import TopicList from './TopicList';
import { Button} from 'reactstrap';
import ListAnalyze from './ListAnalyze'
import GeneralInfo from './GeneralInfo';
class App extends Component {

  state = {
    analyze: [],
    error : false,
    isFetching: false,
    itemAnalyze : null, 
    launched: false
  }; 


  constructor(props){
    super(props)
    // Binding this keyword
    this.launchAnalyze = this.launchAnalyze.bind(this);
    this.getDetails = this.getDetails.bind(this);
  }
  
  render(){
    const {analyze} = this.state;
    const files = analyze.map(analyze => {
      return {
        id: analyze.id , 
        fileName: analyze.fileName
      }
    });

    return (
        <div className="App">
          <header className="App-header">          
            <h4>Expert-AI Assessment</h4>
            <div className="float-right">
              
              <Button color="success" on onClick={this.launchAnalyze} >Launch Analyze</Button>
            </div>
          </header>
 
            { this.state.isFetching && 
              <div>
                <img src={logo} className="App-logo" alt="logo" />
                <h2>Analyze In Progress ...</h2>
              </div>
            }

            <div className="App-intro">
              {!this.state.isFetching && this.state.launched && this.state.analyze.length == 0 &&
                <div>
                <p>Nothing to analyze.. Please make sure that the directory 'input' exists and that files are present to be analyzed</p>
              </div>
              }
              {this.state.error && <p>Error Server - Please ensure that the server is up and running on localhost:8080 </p> }
              
              {files.length>0 && 
                <div>
                  <ListAnalyze files={files} onClick={this.getDetails}/>
                </div>
                
              }
              
              {this.state.itemAnalyze &&
              <div>                  
                   <div key={this.state.itemAnalyze.id}><br/>
                      <h2>{this.state.itemAnalyze.fileName} </h2>
                    </div><br/>

                    <div>
                      <GeneralInfo sentiment={this.state.itemAnalyze.sentiment} filename={this.state.itemAnalyze.fileName} date={this.state.itemAnalyze.analyzeDate} />
                    </div><br/>

                    <div>
                       <CategoryList categories={this.state.itemAnalyze.categories} />                      
                    </div><br/>

                    <div>
                       <TopicList topics={this.state.itemAnalyze.topics} />                      
                    </div><br/>
                  
                    <div>
                       <EntityList entities={this.state.itemAnalyze.entities} />                      
                    </div><br/>
                </div>
              }
            </div>

        </div>
    );
  }


  async launchAnalyze(state){
    this.setState({analyze : [] , error:false  , isFetching: true , launched:true});
    try{
      const response = await fetch('http://localhost:8080/api/analyze');
      const body = await response.json();
      this.setState({analyze : body , error:false  , isFetching: false});
    }catch(e){
      this.setState({analyze : [] , error : true , isFetching: false});
    }
  }

  async getDetails(id){
    this.setState({itemAnalyze : null , error:false  , isFetching: false});
    try{
      const response = await fetch('http://localhost:8080/api/analyze/' + id);
      const body = await response.json();
      console.log(body);
      this.setState({itemAnalyze : body , error:false  , isFetching: false});
    }catch(e){
      this.setState({itemAnalyze : null , error : true , isFetching: false});
    }
  }
}

export default App;
