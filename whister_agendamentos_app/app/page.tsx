import { Data } from "./components/home/data";
import { Relatorio } from "./components/home/relatorio";

export default function Home() {
  return (
    <div>
      <div className="flex flex-col sm:flex-row sm:items-center sm:justify-between gap-4">
        <div>
          <h1 className="text-2xl font-bold text-slate-900 tracking-tight">Painel Principal</h1>
          <p className="text-sm text-slate-500">Resumo geral das atividades de hoje.</p>
        </div>
        <Data />
      </div>
      <Relatorio />
    </div>
  );
}