import { Menu } from "./menu/menu";

interface LayoutProps {
  children?: React.ReactNode;
}

export const Layout: React.FC<LayoutProps> = ({ children }) => {
  return (
    <div className="flex h-screen bg-[#edf2f7] overflow-hidden">
      <Menu />

      <main className="flex-1 p-8 h-screen overflow-hidden flex flex-col">
        {children}
      </main>
    </div>
  );
};