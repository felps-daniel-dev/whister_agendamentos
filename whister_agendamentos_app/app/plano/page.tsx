import { Data } from "../components/home/data";
import { ListaPlanos } from "../components/plano/listagemPlano";

export default function Plano() {
  return (
    <div className="space-y-6">
      <div className="flex flex-col sm:flex-row sm:items-center sm:justify-between gap-4">
        <div>
          <h1 className="text-2xl font-bold text-slate-900 tracking-tight">Planos</h1>
          <p className="text-sm text-slate-500">Gerencie os convenios e condições oferecidas.</p>
        </div>
        <Data />
      </div>

      <div className="flex flex-col sm:flex-row items-center justify-between gap-4 bg-white p-3 rounded-2xl border border-slate-200/80 shadow-xs">
        <div className="relative w-full sm:w-[700px]">
          <input
            type="text"
            placeholder="Buscar por plano..."
            className="w-full pl-10 pr-24 py-2.5 text-sm bg-slate-50 border border-slate-200/80 rounded-xl focus:outline-none focus:border-[#00828a] focus:bg-white text-slate-800 placeholder-slate-400 transition-all"
          />
          <svg
            className="w-4 h-4 text-slate-400 absolute left-3.5 top-1/2 -translate-y-1/2 stroke-2"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
          >
            <path strokeLinecap="round" strokeLinejoin="round" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" />
          </svg>
          
          <button className="absolute right-1.5 top-1/2 -translate-y-1/2 px-3 py-1.5 text-xs font-semibold text-slate-600 bg-white border border-slate-200 hover:bg-slate-50 rounded-lg transition-colors cursor-pointer">
            Buscar
          </button>
        </div>

        <button className="w-full sm:w-auto px-4 py-2.5 bg-[#00828a] hover:bg-[#006e75] text-white text-sm font-semibold rounded-xl transition-all shadow-sm shadow-[#00828a]/20 flex items-center justify-center gap-2 cursor-pointer">
          <svg className="w-4 h-4 stroke-2" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path strokeLinecap="round" strokeLinejoin="round" d="M12 4v16m8-8H4" />
          </svg>
          Novo Plano
        </button>
      </div>

      <div>
        <ListaPlanos />
      </div>
    </div>
  );
}