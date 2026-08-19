import { Data } from "../components/home/data";


export default function Plano(){
    return(
        
         <div className="cabecalho">
               <div className="flex flex-col sm:flex-row sm:items-center sm:justify-between gap-4">
                <div>
                    <h1 className="text-2xl font-bold text-slate-900 tracking-tight">Planos</h1>
                    
                </div>
                <Data/>
            </div>
         </div>
    );
}